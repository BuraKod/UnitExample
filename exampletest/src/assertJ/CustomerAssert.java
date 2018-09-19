package assertJ;

import java.util.ArrayList;
import java.util.List;

public class CustomerAssert {
    private String userName;
    private String email;

    public List<Gift> getGiftList() {
        return giftList;
    }

    private List<Gift> giftList = new ArrayList<>();
    public void addGift(Gift gift){giftList.add(gift);}

    public CustomerAssert(String username,String email){
        this.userName = username;
        this.email = email;
    }
}
