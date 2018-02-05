package net.hitechwebdesign.multiautocomplete;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tokenautocomplete.TokenCompleteTextView;

/**
 * Sample token completion view for basic contact info
 * <p>
 * Created on 9/12/13.
 *
 * @author mgod
 */
public class ContactsCompletionView extends TokenCompleteTextView<SimpleContact> {

    public ContactsCompletionView(Context context) {
        super(context);
    }

    public ContactsCompletionView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ContactsCompletionView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected View getViewForObject(SimpleContact contact) {
        LayoutInflater l = (LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View tokenView = l.inflate(R.layout.item_autocomplete_skills, (ViewGroup) getParent(), false);
        TokenTextView textView = (TokenTextView) tokenView.findViewById(R.id.token_text);
        textView.setText(contact.getName());

        return tokenView;
    }

    @Override
    protected SimpleContact defaultObject(String completionText) {
        //Stupid simple example of guessing if we have an email or not
//        int index = completionText.indexOf('@');
//        if (index == -1) {
//
//        } else {
//            return new SimpleContact( completionText.substring(0, index));
//        }
        return new SimpleContact( completionText);
    }
}
