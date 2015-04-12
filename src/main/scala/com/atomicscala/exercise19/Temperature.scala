package com.atomicscala.exercise19

class Temperature {
  var current = 0.0

  def fahrenheitToKelvin(temperature: Double): Double = {
    current = (temperature - 32) * 5 / 9.0 + 273.15
    current
  }

  def celsiusToKelvin(temperature: Double): Double = {
    current = temperature + 273.15
    current
  }

  def kelvinToFahrenheit(temperature: Double): Double = {
    (current - 273.15) * 9 / 5.0 + 32
  }

  def kelvinToCelsius(temperature: Double): Double = {
    current - 273.15
  }

  def setFahrenheit(now: Double): Unit = {
    fahrenheitToKelvin(now)
  }

  def setCelsius(now: Double): Unit = {
    celsiusToKelvin(now)
  }

  def setKelvin(now: Double): Unit = {
    current = now
  }

  def getFahrenheit: Double = {
    kelvinToFahrenheit(current)
  }

  def getCelsius: Double = {
    kelvinToCelsius(current)
  }

  def getKelvin: Double = {
    current
  }
}
