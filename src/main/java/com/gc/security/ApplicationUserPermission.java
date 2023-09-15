package com.gc.security;

public enum ApplicationUserPermission 
{
	GC_READ("gc:read"),
	GC_WRITE("gc:write"),
	USER_READ("user:read"),
	USER_WRITE("user:write");

    private final String permission;

    ApplicationUserPermission(String permission) 
    {
        this.permission = permission;
    }

    public String getPermission() 
    {
        return permission;
    }
}




//STUDENT_READ("student:read"),
//STUDENT_WRITE("student:write"),
//COURSE_READ("course:read"),
//COURSE_WRITE("course:write");
