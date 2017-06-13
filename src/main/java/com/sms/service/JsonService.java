package com.sms.service;


import java.io.Serializable;

public interface JsonService {
    class Error implements Serializable{
        public String getError() {
            return error;
        }

        public void setError(String error) {
            this.error = error;
        }

        private String error;

        public Error(String error, Object object) {
            this.error = error;
            this.object = object;
        }

        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        private Object object;

    }
    class Success implements Serializable{

        public String getSuccess() {
            return success;
        }

        public void setSuccess(String success) {
            this.success = success;
        }

        private String success;
        public Object getObject() {
            return object;
        }

        public void setObject(Object object) {
            this.object = object;
        }

        private Object object;

        public Success(String success, Object object) {
            this.success = success;
            this.object = object;
        }
    }
}
