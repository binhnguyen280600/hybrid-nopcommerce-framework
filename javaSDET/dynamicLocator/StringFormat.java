package dynamicLocator;

public class StringFormat {
    public static void main(String[] args) {
        String EDIT_ICON_BY_FEMALE = "//td[@data-key='females' and text()='%s']//preceding-sibling::td/button[@class='qgrd-edit-row-btn']";

            String EDIT_ICON_BY_FEMALE_COUNTRY = "//td[@data-key='country' and text()='%s']" +
                    "/preceding-sibling::td[@data-key='females' and text()='%s']" +
                    "/preceding-sibling::td/button[@class='qgrd-edit-row-btn']";

        clickToEditIcon(EDIT_ICON_BY_FEMALE, "384187");
        clickToEditIcon(EDIT_ICON_BY_FEMALE, "12253515");
        clickToEditIcon(EDIT_ICON_BY_FEMALE, "24128");

        clickToEditIcon(EDIT_ICON_BY_FEMALE_COUNTRY, "Afghanistan", "384187");
        clickToEditIcon(EDIT_ICON_BY_FEMALE_COUNTRY, "AFRICA", "12253515");
        clickToEditIcon(EDIT_ICON_BY_FEMALE_COUNTRY, "Armenia", "15999");
    }

    public static void clickToEditIcon(String locator, String...restParameter) {
        System.out.println("Delete to icon: " + String.format(locator, (Object[]) restParameter));
    }
}
