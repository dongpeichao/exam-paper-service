DROP TABLE IF EXISTS `paper`;
CREATE TABLE `t_paper` (
   `id` varchar2(255) NOT NULL,
   `blank_quizzes` varchar2(4000) NOT NULL,
   `teacher_id` varchar2(255) NOT NULL,
   `assembled_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
   `reassembled_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
   PRIMARY KEY (`id`)
);