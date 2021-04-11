package dataDriven;

import org.testng.annotations.DataProvider;

public class DataClass {

    @DataProvider(name = "DeleteData")
    public static Object[][] deleteData() {
        return new Object[][] {{"Luigi", 5}};
    }

    @DataProvider(name = "DataForUserCreation")
    public static Object[][] createUser() {
        return new Object [][] {
                {"Isaac", "Newton", 4},
                {"George", "Orwell", 5},
                {"Graham", "Bell", 6}
        };
    }


}
