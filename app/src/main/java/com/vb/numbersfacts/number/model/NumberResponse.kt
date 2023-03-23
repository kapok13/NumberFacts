package com.vb.numbersfacts.number.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class NumberResponse(@JsonProperty("text") val text: String, @JsonProperty("number") val number: Int)
