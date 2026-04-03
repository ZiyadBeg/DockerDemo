# DockerDemo
In this Project we are going to see some example of Docker in using Spring Micro Service Application

Commands
Bash
docker volume create mera_data

Bash
docker volume ls

Bash
docker volume rm mera_data

PS C:\Users\Ziyad\IdeaProjects\DockerDemo> docker run -d -v namefile-vol:/app -e SERVER_PORT=9090 -p 8080:9090  a68b54559d1ad

PS C:\Users\Ziyad\IdeaProjects\DockerDemo> docker ps
CONTAINER ID   IMAGE          COMMAND               CREATED          STATUS          PORTS                                         NAMES
32e8b4ec45886   a68b55459d1ad   "java -jar app.jar"   20 seconds ago   Up 19 seconds   0.0.0.0:8080->9090/tcp, [::]:8080->9090/tcp   charming_hamilton

PS C:\Users\Ziyad\IdeaProjects\DockerDemo> docker stop 32e8b54ec4886

PS C:\Users\Ziyad\IdeaProjects\DockerDemo> docker run -d -v namefile-vol:/app -e SERVER_PORT=9090 -p 8080:9090  a68b55459d1ad
6c003cb79599f1b78fd1e37e1333d6f8e6d7e7ec16037d0ab953523f805489d18

docker-compose up
docker-compose up -d
docker-compose down
docker-compose ps
docker-compose logs -f