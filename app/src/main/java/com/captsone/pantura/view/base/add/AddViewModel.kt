package com.captsone.pantura.view.base.add

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.captsone.pantura.ml.Foo
import com.captsone.pantura.ml.ML
import com.captsone.pantura.util.Util.reduceFileImage
import com.captsone.pantura.util.Util.uriToFile
import dagger.hilt.android.lifecycle.HiltViewModel
import org.tensorflow.lite.DataType
import org.tensorflow.lite.support.image.TensorImage
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer
import java.io.File
import java.nio.ByteBuffer
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val model: ML
): ViewModel() {

    private val _imageFile = MutableLiveData<File>()
    val imageFile: LiveData<File> = _imageFile

    fun setFile(uri: Uri, context: Context) {
        _imageFile.value = reduceFileImage(uriToFile(uri, context))
        scanData()
    }

    fun setFileFromCamera(file: File) {
        _imageFile.value = file
        scanData()
    }
    private fun scanData() {
        try {
            val tfImage = BitmapFactory.decodeFile(_imageFile.value?.path)
            val inputShape = intArrayOf(1, tfImage?.width ?: 0, tfImage?.height ?: 0, 3)
            val bufferSize = inputShape.reduce { acc, i -> acc * i } * 4 // Multiply by 4 for FLOAT32 data type
            val byteBuffer: ByteBuffer = ByteBuffer.allocate(bufferSize)
            byteBuffer.rewind()
            tfImage?.copyPixelsToBuffer(byteBuffer)
            val inputFeature0 = TensorBuffer.createFixedSize(inputShape, DataType.FLOAT32)
            inputFeature0.loadBuffer(byteBuffer)
            val outputs = model.process(inputFeature0)
            Log.d("OutputModel", outputs.toString())
        } catch (e: Exception) {
            Log.d("OutputModel", "Error $e")
        }
    }
}