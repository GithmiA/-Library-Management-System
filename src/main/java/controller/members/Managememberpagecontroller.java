package controller.members;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Member;

import java.io.IOException;

public class Managememberpagecontroller {

    @FXML
    private TableColumn<Member, Void> actionColumn;

    @FXML
    private Button btnBack;

    @FXML
    private TableColumn<Member, String> emailColumn;

    @FXML
    private TableColumn<Member, String> idColumn;

    @FXML
    private ImageView imgSearch;

    @FXML
    private TableView<Member> memberTable;

    @FXML
    private TableColumn<Member, String> nameColumn;

    @FXML
    private TableColumn<Member, String> phonenumberColumn;

    @FXML
    private TextField txtSearchById;

    Managemembercontroller managemembercontroller = new Managemembercontroller();

    @FXML
    void backOnAction(ActionEvent event) {
        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/view/maindashboard_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }
    @FXML
    void searchById(MouseEvent event) {

    }

    @FXML
    public void initialize(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phonenumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        memberTable.setEditable(true);
        memberTable.setItems(managemembercontroller.loadTable());

        updateMembers();
        setUpActionColumn();

    }

    private void updateMembers() {
        nameColumn.setOnEditCommit(event -> {
            Member member = event.getRowValue();
            member.setFullName(event.getNewValue());
            managemembercontroller.updateMember(member);
        });
        emailColumn.setOnEditCommit(event ->{
            Member member = event.getRowValue();
            member.setEmail(event.getNewValue());
            managemembercontroller.updateMember(member);
        });
        phonenumberColumn.setOnEditCommit(event ->{
            Member member = event.getRowValue();
            member.setPhoneNumber(event.getNewValue());
            managemembercontroller.updateMember(member);
        });
    }

    private void setUpActionColumn() {
        actionColumn.setCellFactory(column -> new TableCell<Member,Void>(){
            private final Button editButton = new Button("Edit");
            private final Button deleteButton = new Button("Delete");

            private final HBox buttons=new HBox(5);
            {
                buttons.getChildren().addAll(editButton,deleteButton);
                editButton.setOnAction(event -> {

                    nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                    emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                    phonenumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());

                    Member member=getTableView().getItems().get(getIndex());

                    if(managemembercontroller.hasBorrowingRecords(member)) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Delete Member");
                        alert.setHeaderText("Cannot Delete Member");
                        alert.setContentText("This member has borrowing records.");
                        alert.showAndWait();
                    }else {
                        if(managemembercontroller.deleteMember(member)) {
                            memberTable.setItems(managemembercontroller.loadTable());
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Delete Member");
                            alert.setHeaderText(null);
                            alert.setContentText("Member Delete Successfully.");
                            alert.showAndWait();
                        }
                    }
                });
                deleteButton.setOnAction(event -> {
                    Member member=getTableView().getItems().get(getIndex());

                    if (managemembercontroller.deleteMember(member)) {
                        memberTable.setItems(managemembercontroller.loadTable());
                    }else {

                    }
                    memberTable.refresh();

                });

            }

            @Override
            protected void updateItem(Void item,boolean empty){
                super.updateItem(item,empty);
                if(empty){
                    setGraphic(null);
                }else {
                    setGraphic(buttons);
                }
            }

        });
    }




}
