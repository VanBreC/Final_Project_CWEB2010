package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class Controller {

    @FXML
    private ImageView backGround;

    @FXML
    private Button submit_btn;

    @FXML
    private Label character_lb0;

    @FXML
    private Label character_lb1;

    @FXML
    private Label character_lb2;

    @FXML
    private Label character_lb3;

    @FXML
    private Label character_lb4;

    @FXML
    private Label character_lb5;

    @FXML
    private Label character_lb6;

    @FXML
    private Label character_lb7;

    @FXML
    private Label character_lb8;

    @FXML
    private Label character_lb9;

    @FXML
    private Label character_lb10;

    @FXML
    private Label character_lb11;

    @FXML
    private Label character_lb12;

    @FXML
    private Label character_lb13;

    @FXML
    private Label character_lb14;

    @FXML
    private Label character_lb15;

    @FXML
    private Label character_lb16;

    @FXML
    private Label character_lb17;

    @FXML
    private TextArea urlTextEntry;

    @FXML
    private ImageView Head;

    @FXML
    private ImageView Neck;

    @FXML
    private ImageView Shoulder;

    @FXML
    private ImageView Back;

    @FXML
    private ImageView Chest;

    @FXML
    private ImageView Shirt;

    @FXML
    private ImageView Tabard;

    @FXML
    private ImageView Hands;

    @FXML
    private ImageView Waist;

    @FXML
    private ImageView Legs;

    @FXML
    private ImageView Feet;

    @FXML
    private ImageView Finger1;

    @FXML
    private ImageView Finger2;

    @FXML
    private ImageView Trinket1;

    @FXML
    private ImageView Trinket2;

    @FXML
    private ImageView MainHand;

    @FXML
    private ImageView OffHand;

    @FXML
    private ImageView Wrist;

    @FXML
    private ChoiceBox<String> cb;

    @FXML
    private void initialize() throws Exception
    {

        submit_btn.setVisible(false);
        urlTextEntry.setVisible(false);
        String url0 = "https://worldofwarcraft.com/en-us/character/us/stormrage/aldaruk";
        String url1 = "https://worldofwarcraft.com/en-us/character/us/turalyon/aldrighton";
        String url2 = "https://worldofwarcraft.com/en-us/character/us/stormrage/symonath";
        Element Name0 = Jsoup.connect(url0).get().select(".CharacterHeader-name").first();
        Element Name1 = Jsoup.connect(url1).get().select(".CharacterHeader-name").first();
        Element Name2 = Jsoup.connect(url2).get().select(".CharacterHeader-name").first();
        ObservableList<String> cbList = FXCollections.observableArrayList("Load Character", Name0.text(), Name1.text(), Name2.text());
        cb.setValue("Load Character");
        cb.setItems(cbList);
        cb.valueProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                try {
                    updateLabels(newValue);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public void updateLabels(String newValue) throws IOException {

        switch (newValue) {
            case ("Aldaruk"):
                submit_btn.setVisible(false);
                urlTextEntry.setVisible(false);
                setCharacter("https://worldofwarcraft.com/en-us/character/us/stormrage/aldaruk");
                break;
            case ("Aldrighton"):
                submit_btn.setVisible(false);
                urlTextEntry.setVisible(false);
                setCharacter("https://worldofwarcraft.com/en-us/character/us/turalyon/aldrighton");
                break;
            case ("Symonath"):
                submit_btn.setVisible(false);
                urlTextEntry.setVisible(false);
                setCharacter("https://worldofwarcraft.com/en-us/character/us/stormrage/symonath");
                break;
            case ("Load Character"):
                submit_btn.setVisible(true);
                urlTextEntry.setVisible(true);
                break;
        }

    }

    private void setCharacter(String url) throws IOException {

        int length = 0;
        int length1 = 0;
        String EmptySlot = "https://worldofwarcraft.akamaized.net/static/components/GameIcon/GameIcon-slots.png";
        Document doc = Jsoup.connect(url).get();
        String backGroundIm = doc.select("meta[property=og:image]").get(0).attr("content");
        backGround.setImage(new Image(backGroundIm));

        Elements aElement1 = doc.select(".CharacterProfile-itemName");
        Elements aElement = doc.select("a[data-modal]");
        Elements Gear = doc.select("div[class=GameIcon-icon]");

        for (Element counting : aElement1){
            if (counting.hasText()) {
                length++;
            }
        }
        for (Element counting : aElement){
            if (counting.hasAttr("data-tooltip")) {
                length1++;
            }
        }
        int a = 0;
        int i = 0;
        System.out.println(length1);



        //Head.setImage(new Image(armorEdit0.substring(2, armorEdit0.length()-3)));
        //Neck.setImage(new Image(armorEdit1.substring(2, armorEdit1.length()-3)));
        //Shoulder.setImage(new Image(armorEdit2.substring(2, armorEdit2.length()-3)));
        //Back.setImage(new Image(armorEdit3.substring(2, armorEdit3.length()-3)));
        //Chest.setImage(new Image(armorEdit4.substring(2, armorEdit4.length()-3)));

        while (a<=length){

            while (!Gear.get(a).toString().contains(".jpg")) {
                System.out.println("Not Loop   "+a);
                System.out.println("Not Loop   "+i);
                String armorEdit0 = Gear.get(a).attr("style").replace("background-image:url", "");
                int b = 18 - (length+1);
                if (a == (length+1)) {
                    break;
                } else if (aElement.get(a).attr("data-modal").contains("head")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, -2, 50, 50);
                    Head.setImage((new Image(EmptySlot)));
                    Head.setViewport(viewportRect);
                    character_lb0.setTextFill(Color.web("#ffffff"));
                    character_lb0.setText("Empty Slot");
                } else if (aElement.get(a).attr("data-modal").contains("neck")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 45, 50, 50);
                    Neck.setImage((new Image(EmptySlot)));
                    Neck.setViewport(viewportRect);
                    character_lb1.setTextFill(Color.web("#ffffff"));
                    character_lb1.setText("Empty Slot");
                } else if (aElement.get(a).attr("data-modal").contains("shoulder")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 95, 50, 50);
                    Shoulder.setImage((new Image(EmptySlot)));
                    Shoulder.setViewport(viewportRect);
                    character_lb2.setTextFill(Color.web("#ffffff"));
                    character_lb2.setText("Empty Slot");
                } else if (aElement.get(a).attr("data-modal").contains("back")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 139, 50, 50);
                    Back.setImage((new Image(EmptySlot)));
                    Back.setViewport(viewportRect);
                    character_lb3.setTextFill(Color.web("#ffffff"));
                    character_lb3.setText("Empty Slot");
                } else if (aElement.get(a).attr("data-modal").contains("chest")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 139, 50, 50);
                    Chest.setImage((new Image(EmptySlot)));
                    Chest.setViewport(viewportRect);
                    character_lb4.setTextFill(Color.web("#ffffff"));
                    character_lb4.setText("Empty Slot");
                } else if (aElement.get(a).attr("data-modal").contains("shirt")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 233, 50, 50);
                    Shirt.setImage((new Image(EmptySlot)));
                    Shirt.setViewport(viewportRect);
                    character_lb5.setTextFill(Color.web("#ffffff"));
                    character_lb5.setText("Empty Slot");
                } else if (aElement.get(a).attr("data-modal").contains("tabard")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 186, 50, 50);
                    Tabard.setImage((new Image(EmptySlot)));
                    Tabard.setViewport(viewportRect);
                    character_lb6.setTextFill(Color.web("#ffffff"));
                    character_lb6.setText("Empty Slot");
                } else if (aElement.get(a).attr("data-modal").contains("wrist")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 186, 50, 50);
                    Wrist.setImage((new Image(EmptySlot)));
                    Wrist.setViewport(viewportRect);
                    character_lb7.setTextFill(Color.web("#ffffff"));
                    character_lb7.setText("Empty Slot");
                }

                i = a - 1;
                a++;
            }
            System.out.println("Main Loop   "+a);
            System.out.println("Main Loop   "+i);
            while (Gear.get(a).toString().contains(".jpg")) {
                System.out.println("Yes Loop   "+a);
                System.out.println("Yes Loop   "+i);
                String armorEdit0 = Gear.get(a).attr("style").replace("background-image:url", "");
                int b = 18 - (length+1);
                System.out.println(b);
                System.out.println("Yes Loop addition   "+ (a-b));
                if (aElement.get(a).attr("data-modal").contains("head")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 0, 0, 0);
                    Head.setImage(new Image(armorEdit0.substring(2, armorEdit0.length() - 3)));
                    Head.setViewport(viewportRect);

                    if (aElement1.get(i).toString().contains("-COMMON")) {
                        character_lb0.setTextFill(Color.web("#fff"));
                        character_lb0.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("UNCOMMON")) {
                        character_lb0.setTextFill(Color.web("#1eff00"));
                        character_lb0.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("RARE")) {
                        character_lb0.setTextFill(Color.web("#0081ff"));
                        character_lb0.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("EPIC")) {
                        character_lb0.setTextFill(Color.web("#c600ff"));
                        character_lb0.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("LEGENDARY")) {
                        character_lb0.setTextFill(Color.web("#ff8000"));
                        character_lb0.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("HEIRLOOM")) {
                        character_lb0.setTextFill(Color.web("#0cf"));
                        character_lb0.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("AZERITE")) {
                        character_lb0.setTextFill(Color.web("#e5cc80"));
                        character_lb0.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("ARTIFACT")) {
                        character_lb0.setTextFill(Color.web("#e5cc80"));
                        character_lb0.setText(aElement1.get(i).text());
                    } else {
                        character_lb0.setTextFill(Color.web("#ff0000"));
                        character_lb0.setText(aElement1.get(i).text());
                    }
                    i++;
                    a++;
                } else if (aElement.get(a).attr("data-modal").contains("neck")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 0, 0, 0);
                    Neck.setImage(new Image(armorEdit0.substring(2, armorEdit0.length() - 3)));
                    Neck.setViewport(viewportRect);
                    if (aElement1.get(i).toString().contains("-COMMON")) {
                        character_lb1.setTextFill(Color.web("#fff"));
                        character_lb1.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("UNCOMMON")) {
                        character_lb1.setTextFill(Color.web("#1eff00"));
                        character_lb1.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("RARE")) {
                        character_lb1.setTextFill(Color.web("#0081ff"));
                        character_lb1.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("EPIC")) {
                        character_lb1.setTextFill(Color.web("#c600ff"));
                        character_lb1.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("LEGENDARY")) {
                        character_lb1.setTextFill(Color.web("#ff8000"));
                        character_lb1.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("HEIRLOOM")) {
                        character_lb1.setTextFill(Color.web("#0cf"));
                        character_lb1.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("AZERITE")) {
                        character_lb1.setTextFill(Color.web("#e5cc80"));
                        character_lb1.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("ARTIFACT")) {
                        character_lb1.setTextFill(Color.web("#e5cc80"));
                        character_lb1.setText(aElement1.get(i).text());
                    } else {
                        character_lb1.setTextFill(Color.web("#ff0000"));
                        character_lb1.setText(aElement1.get(i).text());
                    }
                    i++;
                    a++;
                } else if (aElement.get(a).attr("data-modal").contains("shoulder")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 0, 0, 0);
                    Shoulder.setImage(new Image(armorEdit0.substring(2, armorEdit0.length() - 3)));
                    Shoulder.setViewport(viewportRect);
                    if (aElement1.get(i).toString().contains("-COMMON")) {
                        character_lb2.setTextFill(Color.web("#fff"));
                        character_lb2.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("UNCOMMON")) {
                        character_lb2.setTextFill(Color.web("#1eff00"));
                        character_lb2.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("RARE")) {
                        character_lb2.setTextFill(Color.web("#0081ff"));
                        character_lb2.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("EPIC")) {
                        character_lb2.setTextFill(Color.web("#c600ff"));
                        character_lb2.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("LEGENDARY")) {
                        character_lb2.setTextFill(Color.web("#ff8000"));
                        character_lb2.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("HEIRLOOM")) {
                        character_lb2.setTextFill(Color.web("#0cf"));
                        character_lb2.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("AZERITE")) {
                        character_lb2.setTextFill(Color.web("#e5cc80"));
                        character_lb2.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("ARTIFACT")) {
                        character_lb2.setTextFill(Color.web("#e5cc80"));
                        character_lb2.setText(aElement1.get(i).text());
                    } else {
                        character_lb2.setTextFill(Color.web("#ff0000"));
                        character_lb2.setText(aElement1.get(i).text());
                    }
                    i++;
                    a++;
                } else if (aElement.get(a).attr("data-modal").contains("back")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 0, 0, 0);
                    Back.setImage(new Image(armorEdit0.substring(2, armorEdit0.length() - 3)));
                    Back.setViewport(viewportRect);
                    if (aElement1.get(i).toString().contains("-COMMON")) {
                        character_lb3.setTextFill(Color.web("#fff"));
                        character_lb3.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("UNCOMMON")) {
                        character_lb3.setTextFill(Color.web("#1eff00"));
                        character_lb3.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("RARE")) {
                        character_lb3.setTextFill(Color.web("#0081ff"));
                        character_lb3.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("EPIC")) {
                        character_lb3.setTextFill(Color.web("#c600ff"));
                        character_lb3.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("LEGENDARY")) {
                        character_lb3.setTextFill(Color.web("#ff8000"));
                        character_lb3.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("HEIRLOOM")) {
                        character_lb3.setTextFill(Color.web("#0cf"));
                        character_lb3.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("AZERITE")) {
                        character_lb3.setTextFill(Color.web("#e5cc80"));
                        character_lb3.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("ARTIFACT")) {
                        character_lb3.setTextFill(Color.web("#e5cc80"));
                        character_lb3.setText(aElement1.get(i).text());
                    } else {
                        character_lb3.setTextFill(Color.web("#ff0000"));
                        character_lb3.setText(aElement1.get(i).text());
                    }
                    i++;
                    a++;
                } else if (aElement.get(a).attr("data-modal").contains("chest")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 0, 0, 0);
                    Chest.setImage(new Image(armorEdit0.substring(2, armorEdit0.length() - 3)));
                    Chest.setViewport(viewportRect);
                    if (aElement1.get(i).toString().contains("-COMMON")) {
                        character_lb4.setTextFill(Color.web("#fff"));
                        character_lb4.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("UNCOMMON")) {
                        character_lb4.setTextFill(Color.web("#1eff00"));
                        character_lb4.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("RARE")) {
                        character_lb4.setTextFill(Color.web("#0081ff"));
                        character_lb4.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("EPIC")) {
                        character_lb4.setTextFill(Color.web("#c600ff"));
                        character_lb4.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("LEGENDARY")) {
                        character_lb4.setTextFill(Color.web("#ff8000"));
                        character_lb4.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("HEIRLOOM")) {
                        character_lb4.setTextFill(Color.web("#0cf"));
                        character_lb4.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("AZERITE")) {
                        character_lb4.setTextFill(Color.web("#e5cc80"));
                        character_lb4.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("ARTIFACT")) {
                        character_lb4.setTextFill(Color.web("#e5cc80"));
                        character_lb4.setText(aElement1.get(i).text());
                    } else {
                        character_lb4.setTextFill(Color.web("#ff0000"));
                        character_lb4.setText(aElement1.get(i).text());
                    }
                    i++;
                    a++;
                } else if (aElement.get(a).attr("data-modal").contains("shirt")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 0, 0, 0);
                    Shirt.setImage(new Image(armorEdit0.substring(2, armorEdit0.length() - 3)));
                    Shirt.setViewport(viewportRect);
                    if (aElement1.get(i).toString().contains("-COMMON")) {
                        character_lb5.setTextFill(Color.web("#fff"));
                        character_lb5.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("UNCOMMON")) {
                        character_lb5.setTextFill(Color.web("#1eff00"));
                        character_lb5.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("RARE")) {
                        character_lb5.setTextFill(Color.web("#0081ff"));
                        character_lb5.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("EPIC")) {
                        character_lb5.setTextFill(Color.web("#c600ff"));
                        character_lb5.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("LEGENDARY")) {
                        character_lb5.setTextFill(Color.web("#ff8000"));
                        character_lb5.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("HEIRLOOM")) {
                        character_lb5.setTextFill(Color.web("#0cf"));
                        character_lb5.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("AZERITE")) {
                        character_lb5.setTextFill(Color.web("#e5cc80"));
                        character_lb5.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("ARTIFACT")) {
                        character_lb5.setTextFill(Color.web("#e5cc80"));
                        character_lb5.setText(aElement1.get(i).text());
                    } else {
                        character_lb5.setTextFill(Color.web("#ff0000"));
                        character_lb5.setText(aElement1.get(i).text());
                    }
                    i++;
                    a++;
                } else if (aElement.get(a).attr("data-modal").contains("tabard")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 0, 0, 0);
                    Tabard.setImage(new Image(armorEdit0.substring(2, armorEdit0.length() - 3)));
                    Tabard.setViewport(viewportRect);
                    if (aElement1.get(i).toString().contains("-COMMON")) {
                        character_lb6.setTextFill(Color.web("#fff"));
                        character_lb6.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("UNCOMMON")) {
                        character_lb6.setTextFill(Color.web("#1eff00"));
                        character_lb6.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("RARE")) {
                        character_lb6.setTextFill(Color.web("#0081ff"));
                        character_lb6.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("EPIC")) {
                        character_lb6.setTextFill(Color.web("#c600ff"));
                        character_lb6.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("LEGENDARY")) {
                        character_lb6.setTextFill(Color.web("#ff8000"));
                        character_lb6.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("HEIRLOOM")) {
                        character_lb6.setTextFill(Color.web("#0cf"));
                        character_lb6.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("AZERITE")) {
                        character_lb6.setTextFill(Color.web("#e5cc80"));
                        character_lb6.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("ARTIFACT")) {
                        character_lb6.setTextFill(Color.web("#e5cc80"));
                        character_lb6.setText(aElement1.get(i).text());
                    } else {
                        character_lb6.setTextFill(Color.web("#ff0000"));
                        character_lb6.setText(aElement1.get(i).text());
                    }
                    i++;
                    a++;
                } else if (aElement.get(a).attr("data-modal").contains("wrist")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 0, 0, 0);
                    Wrist.setImage(new Image(armorEdit0.substring(2, armorEdit0.length() - 3)));
                    Wrist.setViewport(viewportRect);
                    if (aElement1.get(i).toString().contains("-COMMON")) {
                        character_lb7.setTextFill(Color.web("#fff"));
                        character_lb7.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("UNCOMMON")) {
                        character_lb7.setTextFill(Color.web("#1eff00"));
                        character_lb7.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("RARE")) {
                        character_lb7.setTextFill(Color.web("#0081ff"));
                        character_lb7.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("EPIC")) {
                        character_lb7.setTextFill(Color.web("#c600ff"));
                        character_lb7.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("LEGENDARY")) {
                        character_lb7.setTextFill(Color.web("#ff8000"));
                        character_lb7.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("HEIRLOOM")) {
                        character_lb7.setTextFill(Color.web("#0cf"));
                        character_lb7.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("AZERITE")) {
                        character_lb7.setTextFill(Color.web("#e5cc80"));
                        character_lb7.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("ARTIFACT")) {
                        character_lb7.setTextFill(Color.web("#e5cc80"));
                        character_lb7.setText(aElement1.get(i).text());
                    } else {
                        character_lb7.setTextFill(Color.web("#ff0000"));
                        character_lb7.setText(aElement1.get(i).text());
                    }
                    i++;
                    a++;
                } else if (aElement.get(a).attr("data-modal").contains("hand")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 0, 0, 0);
                    Hands.setImage(new Image(armorEdit0.substring(2, armorEdit0.length() - 3)));
                    Hands.setViewport(viewportRect);
                    if (aElement1.get(i).toString().contains("-COMMON")) {
                        character_lb8.setTextFill(Color.web("#fff"));
                        character_lb8.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("UNCOMMON")) {
                        character_lb8.setTextFill(Color.web("#1eff00"));
                        character_lb8.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("RARE")) {
                        character_lb8.setTextFill(Color.web("#0081ff"));
                        character_lb8.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("EPIC")) {
                        character_lb8.setTextFill(Color.web("#c600ff"));
                        character_lb8.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("LEGENDARY")) {
                        character_lb8.setTextFill(Color.web("#ff8000"));
                        character_lb8.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("HEIRLOOM")) {
                        character_lb8.setTextFill(Color.web("#0cf"));
                        character_lb8.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("AZERITE")) {
                        character_lb8.setTextFill(Color.web("#e5cc80"));
                        character_lb8.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("ARTIFACT")) {
                        character_lb8.setTextFill(Color.web("#e5cc80"));
                        character_lb8.setText(aElement1.get(i).text());
                    } else {
                        character_lb8.setTextFill(Color.web("#ff0000"));
                        character_lb8.setText(aElement1.get(i).text());
                    }
                    i++;
                    a++;
                } else if (aElement.get(a).attr("data-modal").contains("waist")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 0, 0, 0);
                    Waist.setImage(new Image(armorEdit0.substring(2, armorEdit0.length() - 3)));
                    Waist.setViewport(viewportRect);
                    if (aElement1.get(i).toString().contains("-COMMON")) {
                        character_lb9.setTextFill(Color.web("#fff"));
                        character_lb9.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("UNCOMMON")) {
                        character_lb9.setTextFill(Color.web("#1eff00"));
                        character_lb9.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("RARE")) {
                        character_lb9.setTextFill(Color.web("#0081ff"));
                        character_lb9.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("EPIC")) {
                        character_lb9.setTextFill(Color.web("#c600ff"));
                        character_lb9.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("LEGENDARY")) {
                        character_lb9.setTextFill(Color.web("#ff8000"));
                        character_lb9.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("HEIRLOOM")) {
                        character_lb9.setTextFill(Color.web("#0cf"));
                        character_lb9.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("AZERITE")) {
                        character_lb9.setTextFill(Color.web("#e5cc80"));
                        character_lb9.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("ARTIFACT")) {
                        character_lb9.setTextFill(Color.web("#e5cc80"));
                        character_lb9.setText(aElement1.get(i).text());
                    } else {
                        character_lb9.setTextFill(Color.web("#ff0000"));
                        character_lb9.setText(aElement1.get(i).text());
                    }
                    i++;
                    a++;
                } else if (aElement.get(a).attr("data-modal").contains("leg")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 0, 0, 0);
                    Legs.setImage(new Image(armorEdit0.substring(2, armorEdit0.length() - 3)));
                    Legs.setViewport(viewportRect);
                    if (aElement1.get(i).toString().contains("-COMMON")) {
                        character_lb10.setTextFill(Color.web("#fff"));
                        character_lb10.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("UNCOMMON")) {
                        character_lb10.setTextFill(Color.web("#1eff00"));
                        character_lb10.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("RARE")) {
                        character_lb10.setTextFill(Color.web("#0081ff"));
                        character_lb10.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("EPIC")) {
                        character_lb10.setTextFill(Color.web("#c600ff"));
                        character_lb10.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("LEGENDARY")) {
                        character_lb10.setTextFill(Color.web("#ff8000"));
                        character_lb10.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("HEIRLOOM")) {
                        character_lb10.setTextFill(Color.web("#0cf"));
                        character_lb10.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("AZERITE")) {
                        character_lb10.setTextFill(Color.web("#e5cc80"));
                        character_lb10.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("ARTIFACT")) {
                        character_lb10.setTextFill(Color.web("#e5cc80"));
                        character_lb10.setText(aElement1.get(i).text());
                    } else {
                        character_lb10.setTextFill(Color.web("#ff0000"));
                        character_lb10.setText(aElement1.get(i).text());
                    }
                    i++;
                    a++;
                } else if (aElement.get(a).attr("data-modal").contains("foot")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 0, 0, 0);
                    Feet.setImage(new Image(armorEdit0.substring(2, armorEdit0.length() - 3)));
                    Feet.setViewport(viewportRect);
                    if (aElement1.get(i).toString().contains("-COMMON")) {
                        character_lb11.setTextFill(Color.web("#fff"));
                        character_lb11.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("UNCOMMON")) {
                        character_lb11.setTextFill(Color.web("#1eff00"));
                        character_lb11.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("RARE")) {
                        character_lb11.setTextFill(Color.web("#0081ff"));
                        character_lb11.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("EPIC")) {
                        character_lb11.setTextFill(Color.web("#c600ff"));
                        character_lb11.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("LEGENDARY")) {
                        character_lb11.setTextFill(Color.web("#ff8000"));
                        character_lb11.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("HEIRLOOM")) {
                        character_lb11.setTextFill(Color.web("#0cf"));
                        character_lb11.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("AZERITE")) {
                        character_lb11.setTextFill(Color.web("#e5cc80"));
                        character_lb11.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("ARTIFACT")) {
                        character_lb11.setTextFill(Color.web("#e5cc80"));
                        character_lb11.setText(aElement1.get(i).text());
                    } else {
                        character_lb11.setTextFill(Color.web("#ff0000"));
                        character_lb11.setText(aElement1.get(i).text());
                    }
                    i++;
                    a++;
                } else if (aElement.get(a).attr("data-modal").contains("leftFinger")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 0, 0, 0);
                    Finger1.setImage(new Image(armorEdit0.substring(2, armorEdit0.length() - 3)));
                    Finger1.setViewport(viewportRect);
                    if (aElement1.get(i).toString().contains("-COMMON")) {
                        character_lb12.setTextFill(Color.web("#fff"));
                        character_lb12.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("UNCOMMON")) {
                        character_lb12.setTextFill(Color.web("#1eff00"));
                        character_lb12.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("RARE")) {
                        character_lb12.setTextFill(Color.web("#0081ff"));
                        character_lb12.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("EPIC")) {
                        character_lb12.setTextFill(Color.web("#c600ff"));
                        character_lb12.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("LEGENDARY")) {
                        character_lb12.setTextFill(Color.web("#ff8000"));
                        character_lb12.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("HEIRLOOM")) {
                        character_lb12.setTextFill(Color.web("#0cf"));
                        character_lb12.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("AZERITE")) {
                        character_lb12.setTextFill(Color.web("#e5cc80"));
                        character_lb12.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("ARTIFACT")) {
                        character_lb12.setTextFill(Color.web("#e5cc80"));
                        character_lb12.setText(aElement1.get(i).text());
                    } else {
                        character_lb12.setTextFill(Color.web("#ff0000"));
                        character_lb12.setText(aElement1.get(i).text());
                    }
                    i++;
                    a++;
                } else if (aElement.get(a).attr("data-modal").contains("rightFinger")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 0, 0, 0);
                    Finger2.setImage(new Image(armorEdit0.substring(2, armorEdit0.length() - 3)));
                    Finger2.setViewport(viewportRect);
                    if (aElement1.get(i).toString().contains("-COMMON")) {
                        character_lb13.setTextFill(Color.web("#fff"));
                        character_lb13.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("UNCOMMON")) {
                        character_lb13.setTextFill(Color.web("#1eff00"));
                        character_lb13.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("RARE")) {
                        character_lb13.setTextFill(Color.web("#0081ff"));
                        character_lb13.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("EPIC")) {
                        character_lb13.setTextFill(Color.web("#c600ff"));
                        character_lb13.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("LEGENDARY")) {
                        character_lb13.setTextFill(Color.web("#ff8000"));
                        character_lb13.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("HEIRLOOM")) {
                        character_lb13.setTextFill(Color.web("#0cf"));
                        character_lb13.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("AZERITE")) {
                        character_lb13.setTextFill(Color.web("#e5cc80"));
                        character_lb13.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("ARTIFACT")) {
                        character_lb13.setTextFill(Color.web("#e5cc80"));
                        character_lb13.setText(aElement1.get(i).text());
                    } else {
                        character_lb13.setTextFill(Color.web("#ff0000"));
                        character_lb13.setText(aElement1.get(i).text());
                    }
                    i++;
                    a++;
                } else if (aElement.get(a).attr("data-modal").contains("leftTrinket")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 0, 0, 0);
                    Trinket1.setImage(new Image(armorEdit0.substring(2, armorEdit0.length() - 3)));
                    Trinket1.setViewport(viewportRect);
                    if (aElement1.get(i).toString().contains("-COMMON")) {
                        character_lb14.setTextFill(Color.web("#fff"));
                        character_lb14.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("UNCOMMON")) {
                        character_lb14.setTextFill(Color.web("#1eff00"));
                        character_lb14.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("RARE")) {
                        character_lb14.setTextFill(Color.web("#0081ff"));
                        character_lb14.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("EPIC")) {
                        character_lb14.setTextFill(Color.web("#c600ff"));
                        character_lb14.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("LEGENDARY")) {
                        character_lb14.setTextFill(Color.web("#ff8000"));
                        character_lb14.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("HEIRLOOM")) {
                        character_lb14.setTextFill(Color.web("#0cf"));
                        character_lb14.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("AZERITE")) {
                        character_lb14.setTextFill(Color.web("#e5cc80"));
                        character_lb14.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("ARTIFACT")) {
                        character_lb14.setTextFill(Color.web("#e5cc80"));
                        character_lb14.setText(aElement1.get(i).text());
                    } else {
                        character_lb14.setTextFill(Color.web("#ff0000"));
                        character_lb14.setText(aElement1.get(i).text());
                    }
                    i++;
                    a++;
                } else if (aElement.get(a).attr("data-modal").contains("rightTrinket")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 0, 0, 0);
                    Trinket2.setImage(new Image(armorEdit0.substring(2, armorEdit0.length() - 3)));
                    Trinket2.setViewport(viewportRect);
                    if (aElement1.get(i).toString().contains("-COMMON")) {
                        character_lb15.setTextFill(Color.web("#fff"));
                        character_lb15.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("UNCOMMON")) {
                        character_lb15.setTextFill(Color.web("#1eff00"));
                        character_lb15.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("RARE")) {
                        character_lb15.setTextFill(Color.web("#0081ff"));
                        character_lb15.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("EPIC")) {
                        character_lb15.setTextFill(Color.web("#c600ff"));
                        character_lb15.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("LEGENDARY")) {
                        character_lb15.setTextFill(Color.web("#ff8000"));
                        character_lb15.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("HEIRLOOM")) {
                        character_lb15.setTextFill(Color.web("#0cf"));
                        character_lb15.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("AZERITE")) {
                        character_lb15.setTextFill(Color.web("#e5cc80"));
                        character_lb15.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("ARTIFACT")) {
                        character_lb15.setTextFill(Color.web("#e5cc80"));
                        character_lb15.setText(aElement1.get(i).text());
                    } else {
                        character_lb15.setTextFill(Color.web("#ff0000"));
                        character_lb15.setText(aElement1.get(i).text());
                    }
                    i++;
                    a++;
                } else if (aElement.get(a).attr("data-modal").contains("weapon")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 0, 0, 0);
                    MainHand.setImage(new Image(armorEdit0.substring(2, armorEdit0.length() - 3)));
                    MainHand.setViewport(viewportRect);
                    if (aElement1.get(i).toString().contains("-COMMON")) {
                        character_lb16.setTextFill(Color.web("#fff"));
                        character_lb16.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("-UNCOMMON")) {
                        character_lb16.setTextFill(Color.web("#1eff00"));
                        character_lb16.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("RARE")) {
                        character_lb16.setTextFill(Color.web("#0081ff"));
                        character_lb16.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("EPIC")) {
                        character_lb16.setTextFill(Color.web("#c600ff"));
                        character_lb16.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("LEGENDARY")) {
                        character_lb16.setTextFill(Color.web("#ff8000"));
                        character_lb16.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("HEIRLOOM")) {
                        character_lb16.setTextFill(Color.web("#0cf"));
                        character_lb16.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("AZERITE")) {
                        character_lb16.setTextFill(Color.web("#e5cc80"));
                        character_lb16.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("ARTIFACT")) {
                        character_lb16.setTextFill(Color.web("#e5cc80"));
                        character_lb16.setText(aElement1.get(i).text());
                    } else {
                        character_lb16.setTextFill(Color.web("#ff0000"));
                        character_lb16.setText(aElement1.get(i).text());
                    }
                    i++;
                    a++;
                } else if (aElement.get(a).attr("data-modal").contains("offhand")) {
                    Rectangle2D viewportRect = new Rectangle2D(0, 0, 0, 0);
                    OffHand.setImage(new Image(armorEdit0.substring(2, armorEdit0.length() - 3)));
                    OffHand.setViewport(viewportRect);
                    if (aElement1.get(i).toString().contains("-COMMON")) {
                        character_lb17.setTextFill(Color.web("#fff"));
                        character_lb17.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("UNCOMMON")) {
                        character_lb17.setTextFill(Color.web("#1eff00"));
                        character_lb17.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("RARE")) {
                        character_lb17.setTextFill(Color.web("#0081ff"));
                        character_lb17.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("EPIC")) {
                        character_lb17.setTextFill(Color.web("#c600ff"));
                        character_lb17.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("LEGENDARY")) {
                        character_lb17.setTextFill(Color.web("#ff8000"));
                        character_lb17.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("HEIRLOOM")) {
                        character_lb17.setTextFill(Color.web("#0cf"));
                        character_lb17.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("AZERITE")) {
                        character_lb17.setTextFill(Color.web("#e5cc80"));
                        character_lb17.setText(aElement1.get(i).text());
                    } else if (aElement1.get(i).toString().contains("ARTIFACT")) {
                        character_lb17.setTextFill(Color.web("#e5cc80"));
                        character_lb17.setText(aElement1.get(i).text());
                    } else {
                        character_lb17.setTextFill(Color.web("#ff0000"));
                        character_lb17.setText(aElement1.get(i).text());
                    }
                    i++;
                    a++;
                } else if (a - b == (length+1)) {
                    break;
                }

            }
        }

    }

    @FXML
    void generateCharacter(ActionEvent event) throws IOException {

        String url = urlTextEntry.getText();


        Document doc = Jsoup.connect(url).get();
        Elements aElement = doc.select(".CharacterProfile-itemName");

        character_lb0.setText(aElement.get(0).text());
        character_lb1.setText(aElement.get(1).text());
        character_lb2.setText(aElement.get(2).text());
        character_lb3.setText(aElement.get(3).text());
        character_lb4.setText(aElement.get(4).text());
        character_lb5.setText(aElement.get(5).text());
        character_lb6.setText(aElement.get(6).text());
        character_lb7.setText(aElement.get(7).text());
        character_lb8.setText(aElement.get(8).text());
        character_lb9.setText(aElement.get(9).text());
        character_lb10.setText(aElement.get(10).text());
        character_lb11.setText(aElement.get(11).text());
        character_lb12.setText(aElement.get(12).text());
        character_lb13.setText(aElement.get(13).text());
        character_lb14.setText(aElement.get(14).text());
        character_lb15.setText(aElement.get(15).text());
        character_lb16.setText(aElement.get(16).text());
        character_lb17.setText(aElement.get(17).text());

        //aElement.forEach(x -> System.out.println(x.text()));

    }

}