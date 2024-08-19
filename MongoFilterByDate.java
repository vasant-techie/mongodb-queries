import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

// Define the MongoDB pipeline for filtering
String pipeline = "[{'$match': {'$expr': {'$gt': [{'$dateFromString': {'dateString': '$eventDate'}}, ISODate('2023-01-01T00:00:00Z')]}}}]";

Dataset<Row> filteredDf = spark.read()
    .format("mongodb")
    .option("pipeline", pipeline)
    .option("database", "yourDatabaseName")
    .option("collection", "xyz")
    .load();

filteredDf.show();
