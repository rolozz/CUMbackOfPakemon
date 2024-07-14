package text.modifier.textmodifier.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import text.modifier.textmodifier.model.Text;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class TextServiceImpl implements TextService {

    Text text;

    @Autowired
    public TextServiceImpl(Text text) {
        this.text = text;
    }

    @Override
    public StringBuilder resultDelimiter(String string) {
        return new StringBuilder(
                Arrays.stream(string.split(" "))
                        .filter(s -> !s.isEmpty())
                        .collect(Collectors.joining(" "))
        );
    }

    @Override
    public StringBuilder resultMinus(StringBuilder stringBuilder) {

        for (int i = 1; i < stringBuilder.length() - 1; i++) {
            if (stringBuilder.charAt(0) == '-') {
                stringBuilder.deleteCharAt(0);
            } else if (stringBuilder.charAt(stringBuilder.length() - 1) == '-') {
                stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            }
        }
        for (int i = 1; i < stringBuilder.length() - 1; i++) {
            if (stringBuilder.charAt(i) == '-') {
                char left = stringBuilder.charAt(i - 1);
                char right = stringBuilder.charAt(i + 1);
                stringBuilder.setCharAt(i - 1, right);
                stringBuilder.setCharAt(i + 1, left);
                stringBuilder.deleteCharAt(i);
            }
        }
        return stringBuilder;

    }

    @Override
    public StringBuilder resultPlus(StringBuilder stringBuilder) {
        String result = stringBuilder.toString().replace("+", "!");
        return new StringBuilder(result);
    }

    @Override
    public StringBuilder resultSum(StringBuilder stringBuilder) {

        int sum = 0;
        for (int i = 0; i < stringBuilder.length(); i++) {

            char ch = stringBuilder.charAt(i);
            if (Character.isDigit(ch)) {
                sum += Character.getNumericValue(ch);
                stringBuilder.deleteCharAt(i);
            }

        }
        if (sum == 0) {
            return stringBuilder;
        } else {
            return stringBuilder.append(' ')
                    .append(sum);
        }

    }

    @Override
    public String textModifier(Text text) {

        return (resultSum
                (resultPlus
                        (resultMinus
                                (resultDelimiter(text.getText()))))).toString();

    }

}
