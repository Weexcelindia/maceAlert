
package androidqa;

import android.content.Context;

import com.mace.util.CountryCOde;
import com.mace.util.Zone;

import java.util.ArrayList;

/**
 * The simple Array wheel adapter
 * @param <T> the element type
 */
public class ArrayWheelAdapter<T> extends AbstractWheelTextAdapter {
    
    // items
    private ArrayList items;

    /**
     * Constructor
     * @param context the current context
     * @paramitems the items
     */
    public ArrayWheelAdapter(Context context,ArrayList list) {
        super(context);
        
        //setEmptyItemResource(TEXT_VIEW_ITEM_RESOURCE);
        this.items = list;
    }
    
    @Override
    public CharSequence getItemText(int index) {
        if (index >= 0 && index < items.size()) {
            Object item = items.get(index);
            if (item instanceof CountryCOde) {
                return (CharSequence) ((CountryCOde) item).getCountryname();
            }else if(item instanceof Zone)
            {
                return (CharSequence) ((Zone) item).getName();
            }
            return item.toString();
        }
        return null;
    }

    @Override
    public int getItemsCount() {
        return items.size();
    }
}
