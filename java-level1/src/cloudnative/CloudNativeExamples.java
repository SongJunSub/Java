package cloudnative;

/*
 * 실전 클라우드 네이티브 (심화)
 * - K8s Operator 실전, Istio Traffic Management, Multi-Cloud Provider 추상화
 */

// K8s Operator 실전 예제 (Java Operator SDK, 주석 참고)
/*
@Operator
public class MyOperator extends DefaultController<MyResource> {
    @Override
    public void reconcile(MyResource resource, Context context) {
        // 리소스 상태 관리 및 자동화
        if (resource.getSpec().isEnabled()) {
            // 리소스 생성/업데이트
        } else {
            // 리소스 삭제
        }
    }
}
*/

// Istio Traffic Management 실전 예제 (주석 참고)
/*
# VirtualService.yaml
apiVersion: networking.istio.io/v1alpha3
kind: VirtualService
metadata:
  name: my-service
spec:
  hosts:
    - my-service
  http:
    - route:
        - destination:
            host: my-service
          weight: 80
        - destination:
            host: my-service-v2
          weight: 20
*/

interface CloudProvider {
    void createInstance(String name);
}

class AwsProvider implements CloudProvider {
    public void createInstance(String name) {
        System.out.println("Creating AWS EC2 instance: " + name);
    }
}

class AzureProvider implements CloudProvider {
    public void createInstance(String name) {
        System.out.println("Creating Azure VM instance: " + name);
    }
}

public class CloudNativeExamples {
    public static void main(String[] args) {
        System.out.println("K8s Operator, Istio Traffic Management, Multi-Cloud Provider 등은 주석의 예시를 참고하세요.\n실행은 별도 환경에서 가능합니다.");

        System.out.println("\n--- Multi-Cloud Provider Abstraction Example ---");
        CloudProvider awsProvider = new AwsProvider();
        awsProvider.createInstance("my-aws-vm");

        CloudProvider azureProvider = new AzureProvider();
        azureProvider.createInstance("my-azure-vm");
    }
}