# githubs3

Some notes:

```
$ lein uberjar
$ aws lambda create-function --region us-west-2 --function-name githubs3 --zip-file fileb://$(pwd)/target/githubs3.jar --role arn:aws:iam::101010101010:role/lambda-role --handler githubs3.lambda.SyncToS3 --runtime java8 --timeout 30 --memory-size 512
$ aws lambda update-function-code --region us-west-2 --function-name githubs3 --zip-file fileb://$(pwd)/target/githubs3.jar
$ aws lambda invoke --invocation-type RequestResponse --function-name githubs3 --region us-west-2 --log-type Tail --payload '{"some":"input"}' outfile.txt
$ aws lambda get-function-configuration  --function-name githubs3 
$ aws lambda update-function-configuration --function-name githubs3 --handler githubs3.lambda.SyncToS3
```
