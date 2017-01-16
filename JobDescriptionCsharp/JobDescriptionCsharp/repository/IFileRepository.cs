using JobDescriptionCsharp.domain;
using JobDescriptionCsharp.validator;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace JobDescriptionCsharp.repository
{
    public interface IFileRepository<GenericType> : IRepository<GenericType> where GenericType : Entity
    {
        void loadData();

        void writeData();

        GenericType createFromLine(string line);

        IValidator<GenericType> getValidator();

        string getFileName();

        string transform(GenericType item);
    }
}
