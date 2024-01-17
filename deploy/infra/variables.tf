variable "region" {
  description = "EKS Cluster AWS region"
  type        = string
  default     = "us-west-2"
}

variable "name" {
  description = "EKS Cluster name"
  type = string
  default = "eksdemo"
}

variable "k8sversion" {
  description = "Kubernetes version"
  type = string
  default = "1.28"
}

variable "dbname" {
  description = "Postgresql Database name"
  type      = string
  default = "quarkusquickstarts"
}

variable "dbuser" {
  description = "user name to connect to the datbase"
  type = string
  default = "quarkus"
}