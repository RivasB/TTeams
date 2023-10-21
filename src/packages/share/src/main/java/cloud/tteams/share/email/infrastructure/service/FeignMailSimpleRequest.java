package cloud.tteams.share.email.infrastructure.service;

record FeignMailSimpleRequest(String toEmail, String subject, String message) {
}