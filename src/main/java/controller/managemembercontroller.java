package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import model.MemberStore;

import java.io.IOException;

public class managemembercontroller {

    @FXML
    private TableColumn<Member,Void> actionColumn;

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

    @FXML
    public void initialize(){
        idColumn.setCellValueFactory(new PropertyValueFactory<>("memberId"));
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        emailColumn.setCellValueFactory(new PropertyValueFactory<>("email"));
        phonenumberColumn.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        memberTable.setEditable(true);
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        emailColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        phonenumberColumn.setCellFactory(TextFieldTableCell.forTableColumn());

        nameColumn.setOnEditCommit(event -> {
            Member member = event.getRowValue();
            member.setFullName(event.getNewValue());
        });
        emailColumn.setOnEditCommit(event -> {
            Member member = event.getRowValue();
            member.setEmail(event.getNewValue());
        });
        phonenumberColumn.setOnEditCommit(event -> {
            Member member = event.getRowValue();
            member.setPhoneNumber(event.getNewValue());
        });

        loadMember();

        txtSearchById.textProperty().addListener((observable,oldValue, newValue) -> {
            if (newValue.trim().isEmpty()) {
                loadMember();
            }
        });

    }
    private void loadMember(){
        ObservableList<Member> memberList = FXCollections.observableArrayList(MemberStore.members);
        memberTable.setItems(memberList);

        setUpActionColumn();
        memberTable.refresh();
    }
    private void setUpActionColumn(){
        actionColumn.setCellFactory(column -> new TableCell<Member,Void>(){
            private final Button editButton = new Button("Edit");
            private final Button deleteButton = new Button("Delete");

            private final HBox buttons=new HBox(5);
            {
                buttons.getChildren().addAll(editButton,deleteButton);
                editButton.setOnAction(event -> {
                    Member member=getTableView().getItems().get(getIndex());
                    editMember(member);
                });
                deleteButton.setOnAction(event -> {
                    Member member=getTableView().getItems().get(getIndex());
                    MemberStore.members.remove(member);
                    getTableView().getItems().remove(member);
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
    private void editMember(Member member){
        memberTable.edit(memberTable.getItems().indexOf(member),nameColumn);
    }

    @FXML
    void backOnAction(ActionEvent event) {
        Stage stage=(Stage)((Node) event.getSource()).getScene().getWindow();
        try {
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/maindashboard_page.fxml"))));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.show();

    }

    @FXML
    void searchById(MouseEvent event) {
        String searchId = txtSearchById.getText().trim();

        ObservableList<Member> memberList = FXCollections.observableArrayList(MemberStore.members);
        ObservableList<Member> searchResult = FXCollections.observableArrayList();

        for (Member member : memberList){
            if(member.getMemberId().equalsIgnoreCase(searchId)){

                searchResult.add(member);
            }
        }
memberTable.setItems(searchResult);
    }

}
