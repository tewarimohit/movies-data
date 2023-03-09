package com.tewarimohit.movies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reviews {
    @Id
    private ObjectId id;
    private String body;

    // custom constructor to take the body as ids are self generated
    public Reviews(String body) {
        this.body = body;
    }
}
