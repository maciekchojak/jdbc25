package pl.jdbc;

import org.junit.jupiter.api.*;
import pl.jdbc.models.Person;
import pl.jdbc.models.Phone;
import pl.jdbc.utils.MySqlDriver;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/*
Część poniższych testów integrazcyjnych nie jest poprawna, ponieważ zawierają logikę.
Testy mają w głównej mierze wartość edukacyjną i pokazują realizację poszczególnych funkcjonalności w JDBC.

TODO Poniżej znadują się dane wykorzystywane w testach. Zaleca się ich wykorzystanie :)
Dane dla tabeli Person: 666, 'Jan Konieczny', 'Kopytkowo 99', '' , 'Kozigrod', '64-203', 'Polska'
Dane dla tabeli Phone: 7493123, "2003-01-01", 123456789, "XC32", 666
*/

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JdbcExercises {

    private final Connection connection = MySqlDriver.createConnection();

    private Statement statement;


    @BeforeEach
    public void set_up() throws SQLException {
        statement = connection.createStatement();
    }

    @AfterEach
    public void tear_down() throws SQLException {
        connection.close();
        statement.close();
    }

    @Order(1)
    @Test
    @Timeout(5)
    public void check_connection_with_data_base() throws SQLException {
        assertThat(connection).isNotNull();
    }

    @Order(2)
    @Test
    public void add_new_person_using_sql() throws SQLException {
        final int expectedNumbersOfUpdates = 1;
        String sqlStatement = "insert into `persons`" +
                "(`personId`, `personName`, `addressLine1`, `addressLine2`, `city`, `postalCode`, `country`) " +
                "values ( 666, 'Jan Konieczny', 'Kopytkowo 99', '' , 'Kozigrod', '64-203', 'Polska')";
        int updatedRows = statement.executeUpdate(sqlStatement);


        assertThat(updatedRows).isEqualTo(expectedNumbersOfUpdates);
    }

    @Order(3)
    @Test
    public void get_person_by_id_using_simple_query() throws SQLException {
        //TODO odkomentuj poniższy kod i napisz kod, który zazieleni test
        //assertThat(queryResult).isTrue();
    }


    @Order(4)
    @Test
    public void get_person_by_id_using_prepared_statement() throws SQLException {
        //TODO odkomentuj poniższy kod i napisz kod, który zazieleni test
        //assertThat(queryResult).isTrue();
    }

    @Order(5)
    @Test
    public void add_new_phone_to_person_using_prepared_statement() throws SQLException {
        final int expectedUpdate = 1;

        //TODO odkomentuj poniższy kod i napisz kod, który zazieleni test
        //assertThat(affectedRows).isEqualTo(expectedUpdate);
    }

    @Order(6)
    @Test
    public void modify_model_of_phone_using_prepared_statement() throws SQLException {
        final int expectedUpdate = 1;
        //TODO odkomentuj poniższy kod i napisz kod, który zazieleni test
        //assertThat(affectedRows).isEqualTo(expectedUpdate);
    }

    @Order(7)
    @Test
    public void get_all_persons_from_table_and_parse_to_list_of_person_objects() throws SQLException {
        final Set<Person> people = new HashSet<>();

        //TODO odkomentuj poniższy kod i napisz kod, który zazieleni test
        //assertThat(people.contains(personAddedInAnotherMethod)).isTrue();
    }

    @Order(8)
    @Test
    public void get_list_of_phones_by_person_using_prepared_statement() throws SQLException {
        final Set<Phone> phones = new HashSet<>();
        final int personWithThreePhones = 22;
        final int expectedNumberOfPhones = 3;

        //TODO napisz kod, który zazieleni test
        assertThat(phones.size()).isEqualTo(expectedNumberOfPhones);
    }

    @Order(9)
    @Test
    public void update_phone_using_result_set() throws SQLException {
        final Statement statementWithScroll = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

        //TODO napisz kod, który zazieleni test
        //assertThat(nokiaExistInDb).isTrue();
    }

    //Ten test sprząta wszystko co zostalo dodane do bazy danych
    @Order(100)
    @Test
    public void remove_added_person_and_related_phones() throws SQLException {
        final int expectedNumberOfUpdate = 1;
        final int expectedNumberOfDeletedPhones = 1;

        String delete = "delete from citizens.persons where personId = 666;";
        String deletePhone = "delete from citizens.phones where phoneId = 7493123;";

        final int phonesDeleted = statement.executeUpdate(deletePhone);
        final int deletePerson = statement.executeUpdate(delete);

        assertThat(deletePerson).isEqualTo(expectedNumberOfUpdate);
        assertThat(phonesDeleted).isEqualTo(expectedNumberOfDeletedPhones);
    }
}