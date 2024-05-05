
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
  <title>User Register</title>
  <%@ include file="./components/common_cs_js.jsp"%>

</head>
<body>
  <%@ include file="./components/navbar.jsp"%>
  <div class="container-fluid">
    <div class="row mt-2">
      <div class="col-md-4 offset-md-4 admin">
        <div class="card">
          <%@ include file="./components/message.jsp"%>
          <div class="card-body px-5">
            <img src="resources/images/regis.jpeg" class="rounded mx-auto d-block" alt="img" height="90px" width="90px">
            <h3 class="text-center my-3">Register User</h3>
            <form action="userregister" method="post" onsubmit="return validateForm()">
              <div class="form-group">
                <label for="firstname">First Name<span style="color:red"> *</span></label>
                <input type="text" class="form-control" id="firstname" aria-describedby="emailHelp" name="firstname" placeholder="Enter first name.." required>
                <div id="firstname-error" style="color: red;"></div>
              </div>
              <div class="form-group">
                <label for="lastname">Last Name<span style="color:red"> *</span></label>
                <input type="text" class="form-control" id="lastname" aria-describedby="emailHelp" name="lastname" placeholder="Enter last name.." required>
                <div id="lastname-error" style="color: red;"></div>
              </div>
              <div class="form-group">
                <label for="email">Email<span style="color:red"> *</span></label>
                <input type="email" class="form-control" id="emailid" aria-describedby="emailHelp" name="emailid" placeholder="Enter email id.." required>
                <div id="email-error" style="color: red;"></div>
              </div>
              <div class="form-group">
                <label for="email">Mobile<span style="color:red"> *</span></label>
                <input type="text" class="form-control" id="mobileno" pattern="[1-9]{1}[0-9]{9}" aria-describedby="emailHelp" name="mobileno" placeholder="Enter mobile no.." required>
                <div id="mobile-error" style="color: red;"></div>
              </div>
              <div class="form-group">
                <label for="name">Street<span style="color:red"> *</span></label>
                <input type="text" class="form-control" id="street" aria-describedby="emailHelp" name="street" placeholder="Enter street.." required>
                <div id="street-error" style="color: red;"></div>
              </div>
              <div class="form-group">
                <label for="name">City<span style="color:red"> *</span></label>
                <input type="text" class="form-control" id="city" aria-describedby="emailHelp" name="city" placeholder="Enter city.." required>
                <div id="city-error" style="color: red;"></div>
              </div>
              <div class="form-group">
                <label for="pincode">Pin code<span style="color:red"> *</span></label>
                <input type="text" class="form-control" id="pincode" pattern="[1-9][0-9]{5}" aria-describedby="emailHelp" name="pincode" placeholder="Enter pin code.." required>
                <div id="pincode-error" style="color: red;"></div>
              </div>
              <div class="form-group">
                <label for="password">Password<span style="color:red"> *</span></label>
                <input type="password" class="form-control" id="password" aria-describedby="emailHelp" name="password" placeholder="Enter password.." required>
                <small id="passwordHelpInline" class="text-muted">Must be 8-20 characters long and contain uppercase letters, lowercase letters,  digits, special character.</small>
                <div id="password-error" style="color: red;"></div>
              </div>
              <div class="container text-center">
                <button class="btn custom-bg text-color"><b>Register</b></button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <script>
    var firstNameInput = document.getElementById('firstname');
    var lastNameInput = document.getElementById('lastname');
    var emailInput = document.getElementById('emailid');
    var mobileInput = document.getElementById('mobileno');
    var streetInput = document.getElementById('street');
    var cityInput = document.getElementById('city');
    var pincodeInput = document.getElementById('pincode');
    var passwordInput = document.getElementById('password');

    var firstNameError = document.getElementById('firstname-error');
    var lastNameError = document.getElementById('lastname-error');
    var emailError = document.getElementById('email-error');
    var mobileError = document.getElementById('mobile-error');
    var streetError = document.getElementById('street-error');
    var cityError = document.getElementById('city-error');
    var pincodeError = document.getElementById('pincode-error');
    var passwordError = document.getElementById('password-error');

    firstNameInput.addEventListener('input', function () {
      validateFirstName();
    });

    lastNameInput.addEventListener('input', function () {
      validateLastName();
    });

    emailInput.addEventListener('input', function () {
      validateEmail();
    });

    mobileInput.addEventListener('input', function () {
      validateMobile();
    });

    streetInput.addEventListener('input', function () {
      validateStreet();
    });

    cityInput.addEventListener('input', function () {
      validateCity();
    });

    pincodeInput.addEventListener('input', function () {
      validatePincode();
    });

    passwordInput.addEventListener('input', function () {
      validatePassword();
    });

    function validateFirstName() {
      var firstNameValue = firstNameInput.value.trim();
      if (firstNameValue === '') {
        firstNameError.textContent = 'First name is a required field';
      } else if (!isCharactersOnly(firstNameValue)) {
        firstNameError.textContent = 'Please enter characters only';
      } else {
        firstNameError.textContent = '';
      }
    }

    function validateLastName() {
      var lastNameValue = lastNameInput.value.trim();
      if (lastNameValue === '') {
        lastNameError.textContent = 'Last name is a required field';
      } else if (!isCharactersOnly(lastNameValue)) {
        lastNameError.textContent = 'Please enter characters only';
      } else {
        lastNameError.textContent = '';
      }
    }

    function validateEmail() {
      var emailValue = emailInput.value.trim();
      if (emailValue === '') {
        emailError.textContent = 'Email is a required field';
      } else if (!isValidEmail(emailValue)) {
        emailError.textContent = 'Please enter a valid email';
      } else {
        emailError.textContent = '';
      }
    }

    function validateMobile() {
      var mobileValue = mobileInput.value.trim();
      if (mobileValue === '') {
        mobileError.textContent = 'Mobile number is a required field';
      } else if (!isValidMobile(mobileValue)) {
        mobileError.textContent = 'Please enter a valid mobile number';
      } else {
        mobileError.textContent = '';
      }
    }

    function validateStreet() {
      var streetValue = streetInput.value.trim();
      if (streetValue === '') {
        streetError.textContent = 'Street is a required field';
      } else {
        streetError.textContent = '';
      }
    }

    function validateCity() {
      var cityValue = cityInput.value.trim();
      if (cityValue === '') {
        cityError.textContent = 'City is a required field';
      } else {
        cityError.textContent = '';
      }
    }

    function validatePincode() {
      var pincodeValue = pincodeInput.value.trim();
      if (pincodeValue === '') {
        pincodeError.textContent = 'Pin code is a required field';
      } else if (!isValidPincode(pincodeValue)) {
        pincodeError.textContent = 'Please enter a valid pin code';
      } else {
        pincodeError.textContent = '';
      }
    }

    function validatePassword() {
      var passwordValue = passwordInput.value.trim();
      if (passwordValue === '') {
        passwordError.textContent = 'Password is a required field';
      } else if (!isValidPassword(passwordValue)) {
        passwordError.textContent = 'Password must be 8-20 characters long and contain  uppercase letters,lowercase letters,digits, and special character';
      } else {
        passwordError.textContent = '';
      }
    }

    function isCharactersOnly(value) {
      var regex = /^[a-zA-Z]+$/;
      return regex.test(value);
    }

    function isValidEmail(value) {
      var regex = /\S+@\S+\.\S+/;
      return regex.test(value);
    }

    function isValidMobile(value) {
      var regex = /^[1-9]{1}[0-9]{9}$/;
      return regex.test(value);
    }

    function isValidPincode(value) {
      var regex = /^[1-9][0-9]{5}$/;
      return regex.test(value);
    }

    function isValidPassword(value) {
      var regex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,20}$/;
      return regex.test(value);
    }

    function validateForm() {
      validateFirstName();
      validateLastName();
      validateEmail();
      validateMobile();
      validateStreet();
      validateCity();
      validatePincode();
      validatePassword();

      if (firstNameError.textContent === '' &&
          lastNameError.textContent === '' &&
          emailError.textContent === '' &&
          mobileError.textContent === '' &&
          streetError.textContent === '' &&
          cityError.textContent === '' &&
          pincodeError.textContent === '' &&
          passwordError.textContent === '') {
        return true;
      } else {
        return false;
      }
    }
  </script>
</body>
</html>
