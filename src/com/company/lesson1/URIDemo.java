package com.company.lesson1;

import java.net.URI;
import java.net.URISyntaxException;

public class URIDemo {
    public static void main(String[] args) throws URISyntaxException {
        String[] URIs = {
                "mailto:java-net@java.oracle.com",
                "urn:isbn:096139210x",
                "news:comp.lang.java",
                "https://hello.com/users?q=mark#java",
                "file:///G:/3DMP_3_goda_DZ_06_1541577260.pdf",
                "docs/guids/collections",
                "http://localhost:8080",
                "http://localhost:63342/Netvorking/com/company/Lesson1/12345.html?_ijt=3cm808g2v974odcmstq1m23ia6"
        };

        for (String urIs : URIs) {
            URI uri = new URI(urIs);
            System.out.println("==========================");
            System.out.println("Absolute " + uri.isAbsolute());
            System.out.println("fragment " + uri.getFragment());
            System.out.println("Host " + uri.getHost());
            System.out.println("Path " + uri.getPath());
            System.out.println("Query " + uri.getQuery());
            System.out.println("Port " + uri.getPort());
            System.out.println("UserInfo " + uri.getUserInfo());
        }


        URI base = new URI("https://hello.com");
        URI resolve = base.resolve("/users?q=mark#java");
        System.out.println(resolve);

        URI relativize = base.relativize(new URI("https://hello.com/users?q=mark#java"));
        System.out.println(relativize);


    }
}
