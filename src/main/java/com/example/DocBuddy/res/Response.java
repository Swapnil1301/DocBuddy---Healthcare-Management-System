package com.example.DocBuddy.res;

public class Response<T> {
    private final int statusCode;
    private final String message;
    private final T data;

    // Private constructor so only the Builder can create it
    private Response(ResponseBuilder<T> builder) {
        this.statusCode = builder.statusCode;
        this.message = builder.message;
        this.data = builder.data;
    }

    // Standard Getters
    public int getStatusCode() { return statusCode; }
    public String getMessage() { return message; }
    public T getData() { return data; }

    // Static method to start the builder
    public static <T> ResponseBuilder<T> builder() {
        return new ResponseBuilder<>();
    }

    // The Builder Class
    public static class ResponseBuilder<T> {
        private int statusCode;
        private String message;
        private T data;

        public ResponseBuilder<T> statusCode(int statusCode) {
            this.statusCode = statusCode;
            return this;
        }

        public ResponseBuilder<T> message(String message) {
            this.message = message;
            return this;
        }

        public ResponseBuilder<T> data(T data) {
            this.data = data;
            return this;
        }

        public Response<T> build() {
            return new Response<>(this);
        }
    }
}