echo "starting run build docker";
docker build -t iot-tracking-devices-service .

echo "finished docker build";
echo "starting docker-compose";
docker-compose up;