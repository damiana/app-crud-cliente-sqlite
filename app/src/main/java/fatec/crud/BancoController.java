package fatec.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BancoController {

    private SQLiteDatabase db;
    private CriarBancoDados banco;

    public BancoController(Context context){
        banco = new CriarBancoDados(context);
    }

    public String cadastrarLivros(String titulo, String autor, String editora){

        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(CriarBancoDados.TITULO, titulo);
        valores.put(CriarBancoDados.AUTOR, autor);
        valores.put(CriarBancoDados.EDITORA, editora);

        resultado = db.insert(CriarBancoDados.TABELA, null, valores);
        db.close();

        if (resultado == -1) {
            return "Erro ao inserir registro";
        }
        else {
            return "Registro Inserido com sucesso";
        }
    }

    public Cursor listarLivros() {
        Cursor cursor;
        String[] campos =  {banco.ID,banco.TITULO};
        db = banco.getReadableDatabase();
        cursor = db.query(banco.TABELA, campos, null, null, null, null, null, null);

        if(cursor!=null){
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }
}
