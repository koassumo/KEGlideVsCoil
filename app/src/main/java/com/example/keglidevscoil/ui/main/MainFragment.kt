package com.example.keglidevscoil.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import coil.load
import com.example.keglidevscoil.R
import com.example.keglidevscoil.ui.GladeImageLoader

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        val urlText = "https://apod.nasa.gov/apod/image/2102/SwissAlpsMartianSky1024.jpg"

        // Glide
        // 1. <users-permission> в manifest, также gradle
        // 2. Интерфейс лоудера (в entity), единственный метод принимает на вход
        //    стринговый url и контейнер для отображения
        // 3. Реализация лоудера, где можно указать дополнительные преобразования
        // 4. Вызов лоудера:
        val imageLoader = GladeImageLoader()
        urlText.let { imageLoader.loadInto(it, view.findViewById(R.id.iv_glide)) }

        // Coil
        // 1. <users-permission> в manifest, также gradle
        // 2. -----
        // 3. -----
        // 4. Загрузка сразу из view без создания лоудера
        // (засчет использования в Kotlin - extension functions)
        view.findViewById<ImageView>(R.id.iv_coil).load(urlText)

        //для справки также для Coil:
        //Из ресурсов -
        // imageView.load(R.drawable.image)
        //Из файла -
        // imageView.load(File("/path/to/image.jpg"))

    }
}