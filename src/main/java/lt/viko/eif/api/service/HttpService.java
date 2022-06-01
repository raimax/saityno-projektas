package lt.viko.eif.api.service;

public interface HttpService<T> {
    T get(String url);
}
