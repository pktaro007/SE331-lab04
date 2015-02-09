package camt.se331.shoppingcart.service.textserviceimpl;

import camt.se331.shoppingcart.service.TextService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * Created by Dto on 2/8/2015.
 */
@Service
public class ReverseTextServiceImpl implements TextService {
    @Override
    public String formatText(String input) {
        return StringUtils.reverseDelimited(StringUtils.reverse(input), ' ');
    }
}
