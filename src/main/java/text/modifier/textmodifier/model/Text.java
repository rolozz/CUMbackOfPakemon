package text.modifier.textmodifier.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Text {

    String text;

}
