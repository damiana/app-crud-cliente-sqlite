package fatec.crud;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Damiana Costa
 */

public class CriarBancoDados extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "crudlivros.db";
    public static final String TABELA = "livros";
    public static final String ID = "_id";
    public static final String TITULO = "titulo";
    public static final String AUTOR = "autor";
    public static final String EDITORA = "editora";
    private static final int VERSAO = 1;


    public CriarBancoDados(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase banco) {

        String sql = "CREATE TABLE "+TABELA +
                "( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TITULO + " TEXT, " +
                AUTOR + " TEXT, " +
                EDITORA + " TEXT ) ";

        banco.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase banco, int versaoAntiga, int novaVersao) {
        String sql = "DROP TABLE IF EXISTS " + TABELA;
        banco.execSQL(sql);

        onCreate(banco);
    }
}
