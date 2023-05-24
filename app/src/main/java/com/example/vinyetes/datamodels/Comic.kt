package com.example.vinyetes.datamodels

import java.io.Serializable

class Comic (val titol: String, val preu: String, val imatge: String, val autor: String, val sinopsis: String,
             val demografia: String, val subgeneres: List<String>, val editorial: String,
             val ean: String, val publicacio: String): Serializable