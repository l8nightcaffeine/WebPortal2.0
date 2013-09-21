package com.leveldatainc

import grails.plugins.springsecurity.Secured


/*
Can also do the secured annotation above the whole class instead of just the action
@Secured(['ROLE_ADMIN'])
*/
class SecureController {

	@Secured(['ROLE_ADMIN'])
    def index = {
    	render 'Secure access only'
    }
}