

# MpesaPayment

## Daraja API
https://developer.safaricom.co.ke/

We want to ntergrere the mpeasa api in our simple app.
##Step 1

Set up internet permissions in the android manifest.
<user.....internet:permission>

##step 2
https://futurestud.io/tutorials/retrofit-getting-started-and-android-client
Retrofit client- add the retrofit interface and pass the request parameters.
eg the authorisation values.
this is got from the consumer_secret & consumer_key you can use (https://www.base64encode.org/) to make the base64 code or get it from the code

String credentials = Base64.encodeToString(keyCombined.getBytes(StandardCharsets.UTF_8), Base64.DEFAULT);

##step 3
add the pojos folder and a public Response class to get the response values/parameters

##
in the main project access the interface 
