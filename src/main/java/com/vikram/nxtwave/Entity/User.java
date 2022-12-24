package com.vikram.nxtwave.Entity;

import com.vikram.nxtwave.Enum.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection = "User")
public class User{

    @Id
    private String id;
    private String name;
    private String phone;
    private String email;
    private UserType userType;

    public static class CONSTANTS {
        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String PHONE = "phone";
        public static final String EMAIL = "email";
        public static final String USER_TYPE = "userType";
    }
}
