/*
 * 실전 DevOps/Infra as Code (심화)
 * - Terraform으로 AWS EC2 배포, Helm Chart 실전, GitOps 파이프라인
 */

// Terraform으로 AWS EC2 배포 예제 (주석 참고)
/*
# main.tf
provider "aws" {
  region = "ap-northeast-2"
}
resource "aws_instance" "example" {
  ami           = "ami-0c55b159cbfafe1f0"
  instance_type = "t2.micro"
  tags = { Name = "devops-ec2" }
}
*/

// Helm Chart 실전 예제 (주석 참고)
/*
# Chart.yaml
apiVersion: v2
name: myapp
version: 0.1.0

# values.yaml
replicaCount: 2
image:
  repository: myapp
  tag: latest
service:
  type: ClusterIP
  port: 80
*/

// GitOps 파이프라인 예제 (ArgoCD, 주석 참고)
/*
# argo-app.yaml
apiVersion: argoproj.io/v1alpha1
kind: Application
metadata:
  name: myapp
spec:
  source:
    repoURL: 'https://github.com/myorg/myapp.git'
    path: charts/myapp
    targetRevision: HEAD
  destination:
    server: 'https://kubernetes.default.svc'
    namespace: default
  project: default
*/

public class DevOpsExamples {
    public static void main(String[] args) {
        System.out.println("Terraform AWS EC2 배포, Helm Chart, GitOps 파이프라인 등은 주석의 예시를 참고하세요.\n실행은 별도 환경에서 가능합니다.");
    }
} 