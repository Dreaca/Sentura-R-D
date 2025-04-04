import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    String uid;
    String name;
    String given_name;
    String middle_name;
    String family_name;
    String email;
    String phone_number;
}
