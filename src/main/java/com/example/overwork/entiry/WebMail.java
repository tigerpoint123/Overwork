package com.example.overwork.entiry;

import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@NoArgsConstructor
public class WebMail {

    private String address;
    private String title;
    private String message;
    private MultipartFile multipartFile;

    @Override
    public String toString() {
        return "WebMail{" +
                "address='" + address + '\'' +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", multipartFile=" + multipartFile +
                '}';
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
