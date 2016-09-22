<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<script src="https://www.gstatic.com/firebasejs/3.4.0/firebase.js"></script>
<script>
  // Initialize Firebase
 var config = {
    apiKey: "AIzaSyCJNSDP8yBQ4KrGOeLyYYD5r5J9tNR6kUk",
    authDomain: "finalproject-143812.firebaseapp.com",
    databaseURL: "https://finalproject-143812.firebaseio.com",
    storageBucket: "finalproject-143812.appspot.com",
    messagingSenderId: "192614973989"
  };
  firebase.initializeApp(config);
</script>
<script>


var provider = new firebase.auth.GoogleAuthProvider();
var userData;
provider.addScope('https://www.googleapis.com/auth/plus.login');

firebase.auth().onAuthStateChanged(function(user) {
	  if (user) {
		var userDataArray = user.providerData;
		console.log(userDataArray[0]);
		if(userDataArray.length > 0){
			console.log("Ok");
			userData = userDataArray[0];
			console.log(userData);
			console.log(userData.displayName);
			console.log(userData.email);
			console.log(userData.photoURL);
			console.log(userData.providerId);
			console.log(userData.uid);
			displayData(userData.displayName, userData.email, userData.photoURL,  userData.providerId, userData.uid);
		}
		
	    // User is signed in.
	  } else {
		  console.log("User not logged in. " + user);
		  login();
	    // No user is signed in.
	  }
	});
function login(){console.log("Hello");
firebase.auth().signInWithRedirect(provider);

}
firebase.auth().getRedirectResult().then(function(result) {
	  if (result.credential) {
	    // This gives you a Google Access Token. You can use it to access the Google API.
	    var token = result.credential.accessToken;
		  // The signed-in user info.
		  var user = result.user;
		  //potentially here you want to now redirect to your query start, passing the relevant user info on
		  window.location = "../querystart";
	  
	    // ...
	  }
	  
	}).catch(function(error) {
	  // Handle Errors here.
	  var errorCode = error.code;
	  var errorMessage = error.message;
	  // The email of the user's account used.
	  var email = error.email;
	  // The firebase.auth.AuthCredential type that was used.
	  var credential = error.credential;
	  // ...
	  console.log(errorMessage);
	}); 

/* function displayData(displayName, email, photoURL, providerId, uid){
    document.getElementById("demo").innerHTML = "displayName: " + displayName
    											+ "<br>email: " + email
    											+ "<br>photoURL: " + photoURL
    											+ "<br>providerId: " + providerId
    											+ "<br>uid: " + uid;
} */
 
	
</script>
<div id = "demo"></div>
</body>
</html>