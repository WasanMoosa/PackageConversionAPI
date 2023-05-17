# PackageConversionAPI

Converts the input string to a List of numbers based on a specific logic.


## Prerequisites
Docker: Docker needs to be installed on the system.
Docker Compose: Docker Compose is required for running the application using the provided docker-compose.yml file.

## Getting Started

### Run the API using Docker-compose 
1. Make sure you have Docker and Docker Compose installed.
2. Open a terminal or command prompt and navigate to the project directory.
3. Run the following command to start the application:
`docker-compose up`
4. Wait for Docker to build the container and start the application.
5. Once the application is up and running, you can access the API endpoint at http://localhost:8080/api/convert-measurements.

## API Usage
To use the API endpoint for converting measurements, 
you need to make a GET request to the /convert-measurements endpoint. 
The API expects the input parameter in the request query string, which represents 
the input string for measurements conversion.

### Request Example

GET /convert-measurements?input=your_input_string
Replace `your_input_string` with the actual input string you want to convert.

### Response
The API will respond with a JSON object containing the converted measurements or an empty list.

* If the input is valid and the conversion is successful, 
the API will respond with a JSON array of integers representing the converted measurements. 
The response will have an HTTP status code 200 (OK)

Example response:

```
HTTP/1.1 200 OK
Content-Type: application/json 
[1, 20, 2] 
```

* If the input is an empty string, the API will respond with an empty 
JSON array. The response will have an HTTP status code 200 (OK).

Example response:

```
HTTP/1.1 200 OK 
Content-Type: application/json 
[] 
```

* If the input is invalid, the API will respond with an 
empty JSON array and an HTTP status code 400 (Bad Request). 
The response body will also contain an error message.

Example response:

```
 HTTP/1.1 400 Bad Request 
Content-Type: application/json 
[] 
```

##Test
You can test the API in python by runing file `test.py` 
__Note__: Make sure to run the API before test it.