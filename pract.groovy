set -x
#!/bin/bash
aws elbv2 describe-target-groups --output text | awk -F' ' '{print $13}' |grep -E $1 > tg
> sub.txt
for i in `cat tg`
do  
aws elbv2 describe-target-groups     --target-group-arns $i  --output table |grep -E "TargetGroupName|HttpCode|HealthCheckEnabled|HealthCheckIntervalSeconds|UnhealthyThresholdCount|HealthyThresholdCount|HealthCheckTimeoutSeconds" >> sub.txt 
echo '--------------------------------------------------------------------------------------------------------------' >> sub.txt
done 
