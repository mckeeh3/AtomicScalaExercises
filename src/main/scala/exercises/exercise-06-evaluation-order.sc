// 1. Write an expression that evaluates to true if the sky is “sunny” and
//    the temperature is more than 80 degrees.
var sky = "sunny"
var temperature = 81
val forecast1 = sky == "sunny" && temperature > 80

// 2. Write an expression that evaluates to true if the sky is either
//    “sunny” or “partly cloudy” and the temperature is more than 80
//    degrees.
sky = "partly cloudy"
val forecast2 = (sky == "sunny" || sky == "partly cloudy") && temperature > 80

// 3. Write an expression that evaluates to true if the sky is either
//    “sunny” or “partly cloudy” and the temperature is either more than
//    80 degrees or less than 20 degrees.
temperature = 19
val forecast3 = (sky == "sunny" || sky == "partly cloudy") &&
  (temperature > 80 || temperature < 20)

// 4. Convert Fahrenheit to Celsius. Hint: first subtract 32, then multiply
//    by 5/9. If you get 0, check to make sure you didn’t do integer math.
temperature = 212
val celsius = (temperature - 32) * 5 / 9.0

// 5. Convert Celsius to Fahrenheit. Hint: first multiply by 9/5, then add
//    32. Use this to check your solution for the previous exercise.
//var fahrenheit = celsius * 9 / 5.0 + 32
celsius * 9 / 5.0 + 32

// NOTE: strange problem above in commented out statement. Values are messed up.
