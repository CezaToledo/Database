using System;
using System.Data.SQLite;

namespace SQLiteExample
{
    class Program
    {
        static void Main(string[] args)
        {
            // Define o nome do arquivo database
            string databaseFile = "MyDatabase.sqlite";

            // Cria o arquivo database se ele não existir
            if (!System.IO.File.Exists(databaseFile))
            {
                SQLiteConnection.CreateFile(databaseFile);
                Console.WriteLine("Database file created.");
            }
            else
            {
                Console.WriteLine("Database file already exists.");
            }

            // Abre a conexão com a database
            using (SQLiteConnection connection = new SQLiteConnection($"Data Source={databaseFile};Version=3;"))
            {
                connection.Open();

                // Cria uma tabela
                string createTableQuery = @"
                CREATE TABLE IF NOT EXISTS MyTable (
                    Id INTEGER PRIMARY KEY AUTOINCREMENT,
                    Name TEXT NOT NULL,
                    Age INTEGER NOT NULL
                );";

                using (SQLiteCommand command = new SQLiteCommand(createTableQuery, connection))
                {
                    command.ExecuteNonQuery();
                    Console.WriteLine("Table created.");
                }

                // Inserir dados
                string insertDataQuery = "INSERT INTO MyTable (Name, Age) VALUES ('Alice', 30), ('Bob', 25);";
                using (SQLiteCommand command = new SQLiteCommand(insertDataQuery, connection))
                {
                    command.ExecuteNonQuery();
                    Console.WriteLine("Data inserted.");
                }

                // Endereçar á dados
                string selectDataQuery = "SELECT * FROM MyTable;";
                using (SQLiteCommand command = new SQLiteCommand(selectDataQuery, connection))
                using (SQLiteDataReader reader = command.ExecuteReader())
                {
                    while (reader.Read())
                    {
                        Console.WriteLine($"Id: {reader["Id"]}, Name: {reader["Name"]}, Age: {reader["Age"]}");
                    }
                }

                connection.Close();
            }
        }
    }
}
