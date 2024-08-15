package com.samsung.demoprj.services;

import com.google.gson.Gson;
import com.samsung.demoprj.repositories.models.ListPerson;
import com.samsung.demoprj.repositories.models.Person;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

@Service
public class PersonService implements IPersonService{
    @Override
    public List<Person> getListOfPerson() {
        String jsonContent = this.readRemoteContent("https://reqres.in/api/users?page=1");
        Gson gson = new Gson();
        ListPerson lstPerson = gson.fromJson(jsonContent, ListPerson.class);

        return lstPerson.data;
    }

    private String readRemoteContent(String location) {
        String content;
        try {
            URL url = new URL(location);
            URLConnection urlConnection = null;

            urlConnection = url.openConnection();

            InputStream inputStream = urlConnection.getInputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            content = "";
            String line = "";
            while ((line = reader.readLine()) != null) {
                content += line + "\n";
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content;
    }
}
