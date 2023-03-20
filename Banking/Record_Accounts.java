package Banking;
import java.util.ArrayList;
import java.util.List;

public class Record_Accounts {
    List<Account> accounts_list = new ArrayList<>();

    public void Add_Account(Account a) {
        accounts_list.add(a);
    }
    public boolean Delete_Account(int idx) {
        if (idx >= accounts_list.size()) return false;
        accounts_list.remove(idx);
        return true;
    }
    public Account Get_Account(int idx) {
        return accounts_list.get(idx);
    }
    public int Get_Length() {
        return accounts_list.size();
    }
}
