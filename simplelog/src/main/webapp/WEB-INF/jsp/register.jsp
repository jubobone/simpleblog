<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- content -->
<form id="identicalForm" class="form-horizontal" action="save" method="post"
	data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
    data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
    data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
	<fieldset>
		<legend>Register</legend>
		<div class="form-group">
			<label class="col-sm-3 control-label" for="email">Email</label>
			<div class="col-sm-5">
				<input type="text" class="form-control" name="email" type="email" id="email-input"
                   	data-bv-emailaddress="true" data-bv-emailaddress-message="The input is not a valid email address" />
			</div>
			<div class="col-sm-4" id="email_availability_result"></div> 
		</div>

		<div class="form-group">
            <label class="col-sm-3 control-label">Password</label>
            <div class="col-sm-5">
                <input type="password" class="form-control" name="password"
                    data-bv-identical="true"
                    data-bv-identical-field="confirmPassword"
                    data-bv-identical-message="The password and its confirm are not the same" />
            </div>
        </div>
		<div class="form-group">
            <label class="col-sm-3 control-label">Retype password</label>
            <div class="col-sm-5">
                <input type="password" class="form-control" name="confirmPassword"
                    data-bv-identical="true"
                    data-bv-identical-field="password"
                    data-bv-identical-message="The password and its confirm are not the same" />
            </div>
        </div>
		<div class="form-group">
			<label class="col-sm-3 control-label" for="username">Username</label>
			<div class="col-sm-5">
				<input type="text" name="username" class="form-control" required 
                   data-bv-message="The username is not valid"
                   data-bv-notempty="true" data-bv-notempty-message="The username is required and cannot be empty"
                   data-bv-regexp="true" data-bv-regexp-regexp="^[a-zA-Z0-9_\.]+$" data-bv-regexp-message="The username can only consist of alphabetical, number, dot and underscore"
                   data-bv-stringlength="true" data-bv-stringlength-min="6" data-bv-stringlength-max="30" data-bv-stringlength-message="The username must be more than 6 and less than 30 characters long"
                   data-bv-different="true" data-bv-different-field="password" data-bv-different-message="The username and password cannot be the same as each other" /> 
			</div>
		</div>

		<div class="form-group">
            <div class="col-sm-offset-3 col-sm-5">
                <button class="btn btn-primary" type="submit">Submit</button>
                <button class="btn" type="reset">reset</button>
            </div>
        </div>
	</fieldset>
</form>
    <script type='text/javascript'>
    	jQuery.noConflict();
    	jQuery(document).ready(function($) {
    		$('#identicalForm').bootstrapValidator();
    		$('#email-input').on('change', function() {
		    	    $.ajax({
		    	        url: "/simpleblog/register/availability",
		    	        data: {
		    	            'email' : $('#email-input').val()
		    	        },
		    	        dataType: 'json',
		    	        success: function(result) {
		    	            if(result.available) {
		    	            	$('#email_availability_result').html($('<div><span class="label label-success">This email is available</span></div>').html()); 
		    	            }
		    	            else {
		    	            	$('#email_availability_result').html($('<div><span class="label label-warning">This email is not available</span></div>')); 
		    	            }
		    	        },
		    	        error: function(data){
		    	            //error
		    	        }
		    	    });
	    		});
	    	});
	    
	</script>