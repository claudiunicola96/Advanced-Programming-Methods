using JobDescriptionCsharp.domain;
using JobDescriptionCsharp.exception;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JobDescriptionCsharp.validator
{
    public class JobValidator : IValidator<Job>
    {
        public void validate(Job job)
        {
            if (job.name == "")
                throw new JobException("The name of job can't be empty!");

            if (job.type == "")
                throw new JobException("The type of job can't be empty!");

            if (!(job.type.Equals("full-time") || job.type.Equals("part-time")))
                throw new JobException("The type must be full-time or part-time!");
        }
    }
}
