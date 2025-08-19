# Spring Boot Weather Service

A demo application showcasing a REST API with Spring Boot that integrates with an external weather service.

## Configuration

To run this application, you need to provide an API key from OpenWeatherMap.

### Get a Free API Key

This service relies on the OpenWeatherMap API to fetch weather data. You can obtain a free API key by signing up on
their website:

- https://openweathermap.org/

## API Usage

### Get Weather Data for a City

This endpoint retrieves the current weather information for a specified city.

* **Method:** `GET`
* **URL:** `/api/weather`

#### Request Parameters

| Parameter | Type   | Description                               | Required |
|-----------|--------|-------------------------------------------|:--------:|
| `city`    | String | The name of the city (e.g., `Frankfurt`). |   Yes    |
| `apiKey`  | String | Your personal OpenWeatherMap API key.     |   Yes    |

-----

### Example Requests

#### cURL

```bash
curl -X GET "http://localhost:8080/api/weather?city=Frankfurt&apiKey=YOUR_API_KEY_HERE"
```

#### Browser URL

```
http://localhost:8080/api/weather?city=Frankfurt&apiKey=YOUR_API_KEY_HERE
```

-----

### Example Responses

#### ✅ Success Response (200 OK)

If the city is found, the API will return a JSON object with the current weather data.

```json
{
  "city": "Frankfurt am Main",
  "temperatureCelsius": 19.5,
  "humidityPercentage": 75
}
```

#### ❌ Error Response (404 Not Found)

If the city cannot be found, the API will return a standardized JSON error object with a `404` status.

```json
{
  "timestamp": "XXXXXXXX",
  "status": 404,
  "error": "Not Found",
  "message": "City not found on the external weather service: frankfurta",
  "path": "/api/weather"
}
```

#### Error Response for general errors

````json
{
  "timestamp": "XXXXXXXX",
  "status": 500,
  "error": "Internal Server Error",
  "message": "An unexpected error occurred. Please try again later.",
  "path": "/api/weather"
}
````
