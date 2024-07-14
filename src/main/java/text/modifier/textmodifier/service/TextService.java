package text.modifier.textmodifier.service;

import text.modifier.textmodifier.model.Text;

public interface TextService {

    StringBuilder resultDelimiter(String string);

    StringBuilder resultMinus(StringBuilder stringBuilder);

    StringBuilder resultPlus(StringBuilder stringBuilder);

    StringBuilder resultSum(StringBuilder stringBuilder);

    String textModifier(Text text);

}
