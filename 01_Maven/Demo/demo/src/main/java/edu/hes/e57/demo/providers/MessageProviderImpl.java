package edu.hes.e57.demo.providers;

public class MessageProviderImpl implements MessageProvider {
    @Override
    public String getMessage() {
        return "Hello, World!";
    }
}